import {RouterOutlet} from '@angular/router';
import {Component, OnInit} from '@angular/core';
import {Product} from './api/model';
import {QuarkusQuinoaAPIService} from './api/service/catalog.service';
import {TableModule} from 'primeng/table';
import {TagModule} from 'primeng/tag';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, TableModule, TagModule],
  providers: [QuarkusQuinoaAPIService],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit {
  products!: Product[];

  constructor(private catalogService: QuarkusQuinoaAPIService) {
  }

  ngOnInit() {
    this.catalogService.getApiProduct().subscribe(p => {
      this.products = p;
    });
  }
}

