<template>
<v-app>
  <div class="employee_order_page">
    <h1> {{cafeteria_name}} </h1>
    <br><br><br>
    <div v-for="item in items" :key="item.date">
      <order-table-employee :day="item.day" :date="item.date"/>
      <br><br><br>
    </div>
  </div>
</v-app>
</template>

<script>
import OrderTableEmployee from './OrderTableEmployee.vue'

export default {
  props: {
      cafeteria_name: String,
  },
  components: {
    OrderTableEmployee
  },
  items: [],
  data: () => ({
      items: [
        {day: 'Marti', date: "01.06.2021"},
        {day: 'Miercuri', date: "02.06.2021"},
        {day: 'Joi', date: "03.06.2021"},
      ]
  }),
}
</script>

<style scoped>
.employee_order_page {
  top: 0;
  bottom: 0;
  height: 100%;
  padding-top: 30px;
  padding-right: 20%;
  padding-left: 20%;
}
</style>