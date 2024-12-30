import { RouterOutlet } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Product } from './model/product';
import { ProductService } from './service/productservice';
import { TableModule } from 'primeng/table';
import { TagModule } from 'primeng/tag';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, TableModule, TagModule],
  providers: [ProductService],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit {
  products!: Product[];

  constructor(private productService: ProductService) {}

  ngOnInit() {
    this.products = this.productService.getProductsData();
  }
}

