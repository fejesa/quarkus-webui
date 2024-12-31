import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { provideRouter } from '@angular/router';
import { provideHttpClient, withFetch } from '@angular/common/http';

import { routes } from './app.routes';

import { providePrimeNG } from 'primeng/config';
import Aura from '@primeng/themes/aura';

/**
 * Configuration object for the Angular application.
 * Defines providers and application-wide configurations.
 */
export const appConfig: ApplicationConfig = {
  providers: [
    /**
     * Enables Angular's zone-based change detection with event coalescing.
     * - `eventCoalescing: true` batches multiple change detection cycles to improve performance.
     */
    provideZoneChangeDetection({ eventCoalescing: true }),

    /**
     * Provides the Angular Router configuration.
     * - `routes`: The route definitions for the application.
     */
    provideRouter(routes),

    /**
     * Asynchronously loads animations module to improve application performance.
     * - Provides browser animations for Angular Material and PrimeNG components.
     */
    provideAnimationsAsync(),

    /**
     * Configures PrimeNG to use the Aura theme.
     * - `theme.preset`: Specifies the Aura theme for PrimeNG components.
     */
    providePrimeNG({
      theme: {
        preset: Aura,
      },
    }),

    /**
     * Configures the Angular HTTP client with Fetch API support.
     * - `withFetch()`: Enables the Fetch API for HTTP requests.
     */
    provideHttpClient(withFetch()),
  ],
};
