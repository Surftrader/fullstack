import { Component } from '@angular/core';
import { AxiosService } from "../axios.service";

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent {

  constructor(private axionService: AxiosService) {}

  onLogin(input: any): void {
    this.axionService.request(
      "POST",
      "/login",
      {
        login: input.login,
        password: input.password
      }
    );
  }
}
