/**
 * Generated by orval v7.3.0 🍺
 * Do not edit manually.
 * ProductAPI
 * OpenAPI spec version: 1.0.0
 */
import {
  HttpClient
} from '@angular/common/http'
import type {
  HttpContext,
  HttpEvent,
  HttpHeaders,
  HttpParams,
  HttpResponse as AngularHttpResponse
} from '@angular/common/http'
import {
  Injectable
} from '@angular/core'
import {
  Observable
} from 'rxjs'
import type {
  Product
} from '../model'


type HttpClientOptions = {
  headers?: HttpHeaders | {
      [header: string]: string | string[];
  };
  context?: HttpContext;
  observe?: any;
  params?: HttpParams | {
    [param: string]: string | number | boolean | ReadonlyArray<string | number | boolean>;
  };
  reportProgress?: boolean;
  responseType?: any;
  withCredentials?: boolean;
};



@Injectable({ providedIn: 'root' })
export class ProductAPIService {
  constructor(
    private http: HttpClient,
  ) {}/**
 * @summary Get Products
 */
 getApiProduct<TData = Product[]>(
     options?: Omit<HttpClientOptions, 'observe'> & { observe?: 'body' }
  ): Observable<TData>;
    getApiProduct<TData = Product[]>(
     options?: Omit<HttpClientOptions, 'observe'> & { observe?: 'response' }
  ): Observable<AngularHttpResponse<TData>>;
    getApiProduct<TData = Product[]>(
     options?: Omit<HttpClientOptions, 'observe'> & { observe?: 'events' }
  ): Observable<HttpEvent<TData>>;getApiProduct<TData = Product[]>(
     options?: HttpClientOptions
  ): Observable<TData>  {
    return this.http.get<TData>(
      `http://localhost:8081/api/product`,options
    );
  }

};

export type GetApiProductClientResult = NonNullable<Product[]>
