<template>
  <div id="grid">
    <v-row dense>
      <v-col cols="4" v-for="(item, i) in items" :key="i">
        <v-card class="mx-auto my-12" max-width="374" @click="in_v(item.id)">
          <v-img height="250" :src="item.imageURL"></v-img>

          <v-card-title>{{ item.name }}</v-card-title>

          <v-card-text>
            <v-row align="center" class="mx-0"> </v-row>

            <div class="my-4 subtitle-1">Pret: {{ item.unitPrice }} lei</div>

            <div></div>
            <v-row align="center" class="mx-0"> </v-row>

            <div class="my-4 subtitle-1">
              Portia: {{ item.unitValue }} {{ item.unitType }}
            </div>

            <div></div>
          </v-card-text>

          <v-divider class="mx-4"></v-divider>
        </v-card>
      </v-col>
      <v-dialog v-model="dialog" max-width="500px">
        <v-card>
          <v-card-title>
            Doriti sa comandati?
          </v-card-title>
          <v-card-actions>
            <v-col>
              <v-row>
                <v-menu
                    ref="menu"
                    v-model="menu2"
                    :close-on-content-click="false"
                    :nudge-right="40"
                    :return-value.sync="time"
                    transition="scale-transition"
                    offset-y
                    max-width="290px"
                    min-width="290px"
                >
                  <template v-slot:activator="{ on, attrs }">
                    <v-text-field
                        v-model="time"
                        label="Picker in menu"
                        prepend-icon="mdi-clock-time-four-outline"
                        readonly
                        v-bind="attrs"
                        v-on="on"
                    ></v-text-field>
                  </template>
                  <v-time-picker
                      :allowed-hours="allowedHours"
                      v-if="menu2"
                      v-model="time"
                      format="24hr"
                      full-width
                      @click:minute="$refs.menu.save(time)"
                  ></v-time-picker>
                </v-menu>
              </v-row>
              <v-row>
                <v-btn color="green" text @click="new_order(time)">
                  Yes
                </v-btn>
                <v-btn color="primary" text @click="dialog = false">
                  Close
                </v-btn>
              </v-row>
            </v-col>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-row>
  </div>
</template>

<script>
import api from "../components/backend-api";
export default {
  name: "menuPageUser",
  data() {
    return {
      name: window.location.pathname.split("/")[2],
      items: [],
      dialog: false,
      time: null,
      menu2: false,
      id: ""
    };
  },
  created() {
    this.initialize();
  },
  watch: {},
  methods: {
    allowedHours: v => v >= 9 && v <= 15,
    initialize() {
      api
        .getMenuElementsFromCafeteria(this.name)
        .then(response => {
          //console.log(response.data);
          this.items = response.data;
        })
        .catch(error => {
          this.errors.push(error);
        });
    },
    new_order(time) {
      this.dialog = false;
      console.log(this.id + ""+time);
      api.add_new_order(this.id, time);
    },
    in_v(id){
      console.log("in v_");
      console.log(id);
      this.id = id;
      this.dialog = true;
    }
  }
};
</script>

<style scoped>
#grid {
  width: 60%;
  margin: auto;
}
</style>
