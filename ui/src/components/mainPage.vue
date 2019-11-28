<template>
  <v-app id="inspire">
    <v-navigation-drawer
      v-model="drawer"
      app
      clipped
    >
      <v-list dense>
        <v-list-item>
          <v-list-item-action>
            <v-icon>mdi-view-dashboard</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>
                   <div class="text-center">
                       <v-menu offset-y>
                         <template v-slot:activator="{ on }">
                           <v-btn
                             color="primary"
                             dark
                             v-on="on"
                           >
                                Select Dealer
                           </v-btn>
                         </template>
                         <v-list>
                           <v-list-item
                             v-for="(item, index) in dealers"
                             :key="index"
                             @click="selectedDealer(item.name)"
                           >
                             <v-list-item-title>{{ item.name }}</v-list-item-title>
                           </v-list-item>
                         </v-list>
                       </v-menu>
                     </div>
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>


        <v-list-item>
         <v-list-item-action>
                  <v-icon>mdi-football</v-icon>
         </v-list-item-action>
         <v-list-item-content>
                    <v-list-item-title>
                         <v-text-field
                                                    placeholder="thrown at"
                                                    v-model="startAt"
                                                    single-line
                                                   ></v-text-field>
                    </v-list-item-title>
                          <v-btn rounded color="error" dark @click="addData(startAt, finishAt)">Add Data</v-btn>
                     <v-list-item-content>
                                        <v-list-item-title>
                                             <v-text-field
                                              placeholder="finish at"
                                              v-model="finishAt"
                                              single-line
                                              ></v-text-field>
                                        </v-list-item-title>
                                        <v-btn rounded color="green" dark @click="getData(finishAt)">View Data</v-btn>
                                      </v-list-item-content>
         </v-list-item-content>

       </v-list-item>



       <br><br><br><br><br><br><br>
       <v-list-item>
         <v-list-item-action>
                  <v-icon>mdi-soccer</v-icon>
         </v-list-item-action>
                  <v-list-item-content>
                    <v-list-item-title>
                         <v-text-field
                                                    placeholder="Dealer Name"
                                                    v-model="dealer"
                                                    single-line
                                                  ></v-text-field>
                    </v-list-item-title>
                     <v-btn rounded color="warning" dark :disabled="dealer == 1" @click="addDealer(dealer)" >Add Dealer</v-btn>
                  </v-list-item-content>
        </v-list-item>

      </v-list>
    </v-navigation-drawer>

    <v-app-bar
      app
      clipped-left
    >
         <v-toolbar-title>Roulette</v-toolbar-title>
    </v-app-bar>

    <v-content>
      <v-container
        fluid
      >
            <v-list >
              <v-list-item-group v-model="item" color="primary">
                <v-list-item
                  v-for="(item, i) in data"
                  :key="i"
                >
                    <v-list-item-content>
                        <v-list v-text="item.dealer"></v-list>
                     </v-list-item-content>

                    <v-list-item-content>
                      <v-list v-text="item.delta"></v-list>
                    </v-list-item-content>

                        <v-list-item-content>
                         <v-list v-text="item.numbers"></v-list>
                        </v-list-item-content>

                </v-list-item>
              </v-list-item-group>
            </v-list>
      </v-container>
    </v-content>

    <v-footer app>
      <span>&copy; 2019</span>
    </v-footer>
  </v-app>
</template>

<script>
import http from "../http-common";

  export default {
    props: {
      source: String,
    },
      data() {
              return {
                  dealers: [],
                  data: [{
                    "dealer": "bob",
                    "delta": "15",
                    "numbers": [15,25,23,25]
                  }]
              };
          },
      methods: {
      getData(start) {
                    var params = "/getData?dealer="+this.selectedDealer+"&start="+start;
                    http.get(params)
                            .then(response => {
                            this.data = response.data;
                        })
                },
      addData(start, finish) {
            var params = {"dealer":this.selectedDealer, "startAt":start, "finishAt":finish};
            http.post("/addData",params)
                                        .then(response => {
                                        this.data = response.data;
                                    })
      },
      selectedDealer(name){
        this.selectedDealer = name;
      },
      getSelectedDealer(){
        return this.selectedDealer;
      },
      addDealer(name){
            var params = {"name":name};
            http.post("/addDealer",params)
                 .then(response => {
                 this.data = response.data;
             });
      },
      isAddButtonDisabled(dealer){
        if (dealer){
            return false;
        }
        return true;
      }

      },
    created () {
      this.$vuetify.theme.dark = true;
      this.dealers =  http.get("/getDealers")
                                                     .then(response => {
                                                         this.dealers = response.data;
                                                     })
    }
  }
</script>