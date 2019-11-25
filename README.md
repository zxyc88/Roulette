UI:

1. `npm install -g @vue/cli` used to set up vue cli
2. `vue create ui` creates ui folder
3. cd into ui `cd ui`
4. `vue add vuetify` adds veutify to ui
5. `npm run serve` runs the UI  
6. `npm install --save vue-router` 


### db schema changes
1. update the ```./schema/create_db_postgres.sql``` file with the updated schema
2. recreate the db in docker-compose ```docker-compose rm -fs``` ```docker-compose up```
3. run the schema generation mvn profile ```mvn clean install -pcreate-schema```
