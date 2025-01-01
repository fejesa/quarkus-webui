import { defineConfig } from 'orval';

export default defineConfig({
  catalog: {
    /** The path of the generated OpenAPI scheme */
    input: 'api/catalog.yaml',
    output: {
      /** Generates the scheme and client implementation in different files */
      mode: 'split',
      /**  Path to the folder where you want to generate all your models. */
      schemas: 'src/app/api/model',
      /** Path to the file which will contains the client implementation. */
      target: 'src/app/api/service/catalog.ts',
      /** Type of the client that we use */
      client: 'angular',
      /** Base url of the API; it is generated to the client implementation. It should be configuration value. */
      baseUrl: 'http://localhost:8081'
    },
    hooks: {
      afterAllFilesWrite: 'prettier --write',
    },
  },
});
