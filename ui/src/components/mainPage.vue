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
                             select dealer
                           </v-btn>
                         </template>
                         <v-list>
                           <v-list-item
                             v-for="(item, index) in dealers"
                             :key="index"
                           >
                             <v-list-item-title>{{ item.dealer }}</v-list-item-title>
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
                                                    v-model="test"
                                                    single-line
                                                  ></v-text-field>
                    </v-list-item-title>
                  </v-list-item-content>
        </v-list-item>

        <v-list-item>
         <v-list-item-action>
                  <v-icon>mdi-apple</v-icon>
         </v-list-item-action>
                  <v-list-item-content>
                    <v-list-item-title>
                         <v-text-field
                                                    placeholder="landed at"
                                                    v-model="test"
                                                    single-line
                                                  ></v-text-field>
                    </v-list-item-title>
                  </v-list-item-content>
        </v-list-item>

        <v-list-item>
                 <v-list-item-action>
                          <v-icon>mdi-apple</v-icon>
                 </v-list-item-action>
                 <v-list-item-title>
                     <v-btn rounded color="error" dark @click="removeAll">Add Number</v-btn>
                 </v-list-item-title>
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
                                                    v-model="test"
                                                    single-line
                                                  ></v-text-field>
                    </v-list-item-title>
                  </v-list-item-content>
        </v-list-item>

        <v-list-item>
                 <v-list-item-action>
                          <v-icon>mdi-tennis</v-icon>
                 </v-list-item-action>
                 <v-list-item-title>
                     <v-btn rounded color="warning" dark @click="removeAll">Add Dealer</v-btn>
                 </v-list-item-title>
        </v-list-item>


      </v-list>
    </v-navigation-drawer>

    <v-app-bar
      app
      clipped-left
    >
      <v-app-bar-nav-icon @click.stop="drawer = !drawer" />
      <v-toolbar-title>Roulette</v-toolbar-title>
    </v-app-bar>

    <v-content>
      <v-container
        class="fill-height"
        fluid
      >
        <v-row
          align="center"
          justify="center"
          padding-left="50px"
        >

            <v-list >
              <v-subheader>Numbers</v-subheader>
              <v-list-item-group v-model="item" color="primary">
                <v-list-item
                  v-for="(item, i) in items"
                  :key="i"
                >
                  <v-list-item-icon>
                    <v-icon v-text="item.icon"></v-icon>
                  </v-list-item-icon>
                  <v-list-item-content>
                    <v-list-item-title v-text="item.text"></v-list-item-title>
                  </v-list-item-content>
                </v-list-item>
              </v-list-item-group>
            </v-list>
        </v-row>


      </v-container>
    </v-content>

    <v-footer app>
      <span>&copy; 2019</span>
    </v-footer>
  </v-app>
</template>

<script>
  export default {
    props: {
      source: String,
    },
 data: () => ({
        item: 1,
        items: [
          { text: '23 - 15%', icon: 'mdi-clock' },
          { text: '15', icon: 'mdi-account' },
          { text: '7', icon: 'mdi-flag' },
        ],
        dealers: [
            { dealer: 'bob' }
        ]
      }),
    created () {
      this.$vuetify.theme.dark = true
    },
  }
</script>