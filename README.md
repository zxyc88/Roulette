###  UI

1. `npm install -g @vue/cli` used to set up vue cli
2. `vue create ui` creates ui folder
3. `cd ui` moves you to ui folder
4. `vue add vuetify` adds veutify to ui
5. `npm run serve` runs the UI  
6. `npm install --save vue-router` 
7.  `npm install --save axios`


### db schema changes
1. update the ```./schema/create_db_postgres.sql``` file with the updated schema
2. recreate the db in docker-compose ```docker-compose rm -fs``` ```docker-compose up -d```