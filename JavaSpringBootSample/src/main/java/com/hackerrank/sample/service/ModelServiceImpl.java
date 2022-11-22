package com.hackerrank.sample.service;

import com.hackerrank.sample.exception.BadResourceRequestException;
import com.hackerrank.sample.exception.NoSuchResourceFoundException;
import com.hackerrank.sample.model.Model;
import com.hackerrank.sample.repository.ModelRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {
    @Autowired
    private ModelRepository modelRepository;

    @Override
    public void deleteAllModels() {
        modelRepository.deleteAllInBatch();
    }

    @Override
    public void deleteModelById(Long id) {
        modelRepository.deleteById(id);
    }

    @Override
    public void createModel(Model model) {
        modelRepository.findById(model.getId())
            .ifPresent(i -> new BadResourceRequestException("Model with same id exists."));

        modelRepository.save(model);
    }

    @Override
    public Model getModelById(Long id) {
        return modelRepository.findById(id)
            .orElseThrow(() -> new NoSuchResourceFoundException("No model with given id found."));
    }

    @Override
    public List<Model> getAllModels() {
        return modelRepository.findAll();
    }
}
