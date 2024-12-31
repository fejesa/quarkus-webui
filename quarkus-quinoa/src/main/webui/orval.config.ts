import { defineConfig } from 'orval';

export default defineConfig({
  catalog: {
    input: 'api/catalog.yaml',
    output: {
      mode: 'split',
      schemas: 'src/app/api/model',
      target: 'src/app/api/service/catalog.ts',
      client: 'angular',
      baseUrl: 'http://localhost:8080'
    },
    hooks: {
      afterAllFilesWrite: 'prettier --write',
    },
  },
});
