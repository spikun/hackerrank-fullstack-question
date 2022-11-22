import { Component, NgZone } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'sample';
  terminalText = "";

  constructor(
    private zone: NgZone, 
    private httpClient: HttpClient
  ) {
  }

  getModels(): void {
    this.httpClient.get('http://localhost:8080/model', { responseType: 'json' })
      .subscribe((data) => {
        this.terminalText = JSON.stringify(data, null, 2);
      });
  }
}
