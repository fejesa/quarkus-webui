import {RouterOutlet} from '@angular/router';
import {Component, OnInit} from '@angular/core';
import {Product} from './api/model';
import {ProductAPIService} from './api/service/catalog.service';
import {TableModule} from 'primeng/table';
import {TagModule} from 'primeng/tag';
import {CommonModule} from '@angular/common';

/**
 * Root component of the Angular application.
 * Displays a product catalog in a table using PrimeNG components.
 */
@Component({
  selector: 'app-root', // Custom HTML tag for this component.
  standalone: true, // Marks this as a standalone component, not part of a module.
  imports: [
    CommonModule, // Provides common Angular directives like ngIf and ngFor.
    RouterOutlet, // Enables routing and renders child routes.
    TableModule, // PrimeNG module for rendering data tables.
    TagModule // PrimeNG module for rendering tags/labels.
  ],
  providers: [
    ProductAPIService // Service for fetching product data from the backend.
  ],
  templateUrl: './app.component.html', // Path to the component's HTML template.
  styleUrl: './app.component.scss' // Path to the component's SCSS styles.
})
export class AppComponent implements OnInit {

  /** Array of products to display in the table. */
  products!: Product[];

  /**
   * Initializes the component and injects the catalog service.
   * @param catalogService The service for accessing the product API.
   */
  constructor(private catalogService: ProductAPIService) {
  }

  /**
   * Lifecycle hook called when the component is initialized.
   * Fetches product data from the API and assigns it to the `products` property.
   */
  ngOnInit() {
    this.catalogService.getApiProduct().subscribe(p => {
      this.products = p;
    });
  }
}

