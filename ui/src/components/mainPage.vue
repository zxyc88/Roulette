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
                                Pokemon
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
                            <div class="text-center">
                              <v-bottom-sheet v-model="sheet">
                                <template v-slot:activator="{ on }">
                                  <v-btn
                                    color="error"
                                    dark
                                    v-on="on"
                                  >
                                    Add
                                  </v-btn>
                                </template>
                                <v-sheet class="text-center" height="200px">
                                  <v-btn
                                    color="red"
                                    rounded
                                    @click="addData(startAt, finishAt)"
                                  >Confirm Add</v-btn>
                                  <div>Add Start at {{startAt}} and finish at {{finishAt}} for {{this.selectedDealer}}</div>
                                </v-sheet>
                              </v-bottom-sheet>
                            </div>
                     <v-list-item-content>
                                        <v-list-item-title>
                                             <v-text-field
                                              placeholder="finish at"
                                              v-model="finishAt"
                                              single-line
                                              ></v-text-field>
                                        </v-list-item-title>
                                        <v-btn rounded color="green" dark @click="getData(startAt)">View</v-btn>
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
                     <v-btn rounded color="warning" dark :disabled="dealer == 1" @click="addDealer(dealer)" >Add Pokemon</v-btn>
                  </v-list-item-content>
        </v-list-item>

      </v-list>
    </v-navigation-drawer>

    <v-app-bar
      app
      clipped-left
    >
         <v-toolbar-title>Bababoi</v-toolbar-title>
         <v-text>{{this.selectedDealer}}</v-text>
    </v-app-bar>

    <v-content>
      <v-container
        fluid
      >

            <v-list >
              <v-list-item-group v-model="item" color="primary">
                <v-list-item
                  v-for="(item, i) in information"
                  :key="i"
                >
                    <v-list-item-content>
                        <v-list v-text="item.dealerName"></v-list>
                     </v-list-item-content>

                    <v-list-item-content>
                      <v-list v-text="item.realDeltaSD"></v-list>
                    </v-list-item-content>

                     <v-list-item-content>
                          <v-list v-text="item.deltaSD"></v-list>
                      </v-list-item-content>

                        <v-list-item-content>
                         <v-list v-text="item.bestNumbers"></v-list>
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
                  information: [],
                  sheet: false
              };
          },
      methods: {
      getData(start) {
      var params = "/getData?dealer="+this.selectedDealer+"&start="+start;
      this.information =  http.get(params).then(response => {
                                                         this.information = response.data;
                                                     });
                },
      addData(start, finish) {
            var params = {"dealer":this.selectedDealer, "startAt":start, "finishAt":finish};
            http.post("/addData",params)
                                        .then(response => {
                                            this.okay = response.data;
                                    });
            this.sheet  = !this.sheet
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
                 this.dealers = response.data;
             });
             this.selectedDealer = name;
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
                                                     });
      this.selectedDealer = "xxxxXXXX";
    }
  }
</script>