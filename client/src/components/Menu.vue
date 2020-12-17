<template>
    <div id="menu">     
        <v-container grid-list-xl>
            <ul id="menu-items">
                <li v-for="item in menu" :key="item.id">
                    <v-card class="mx-auto" outlined width=250>
                    <div class="text-center">
                        <v-btn
                            tile
                            x-small
                            color="SUCCESS"
                            @click="remove(item)"
                        >
                            X
                        </v-btn>
                    </div>

                    <div class="name">
                        {{ nameMessage }} {{ item.name }} 
                    </div>
                    <div class="calories">
                        {{ calorieMessage }} {{ item.calories }} 
                    </div>
                    <div class="ingredients">
                        {{ ingredientMessage }} {{ item.ingredients }}
                    </div>
                    <div class="price" >
                        <v-col class="text-right">
                        {{ priceMessage }} {{ item.price }}
                        </v-col>
                    </div>
                    <v-btn block @click="addToOrder(item)">Add to Order</v-btn>
                    </v-card>
                </li>
            </ul>
        </v-container>
        {{ this.cart}} ----
        {{ "Total Price: $" + this.total }}
    </div>
</template>

<script>
import axios from 'axios'
import { store } from '../store/'
export default {
    store, 
    data() {
        return {
            menu: [],
            nameMessage: 'Name:',
            calorieMessage: 'Calories: ',
            priceMessage: '$: ',
            ingredientMessage: 'Ingredients: ',
            cart: [],
            total: 0
        }
    },
    mounted() {
      axios
      .get('http://localhost:8000/recipe/menu')
      .then(response => (this.menu = response.data))
      console.log(this.menu)
    },
    methods: {
        addToOrder(item) {
            this.cart.push(item)
            
            var total = this.total
            total = total + item.price
            this.total = total
        },
        remove(item) {
            var name = item.name
            var id = 0
            for(var i = 0; i < menu.length; i++) {
                if (name == menuItem.name)
                    id = menuItem[0].id
            }
            menu.remove(id)
            axios.delete(`http://localhost:8000/recipe/delete?id=${id}`)
        }
    }

    
}
</script>

<style>
ul {
width: 90%; 
    list-style-type:none;
    margin:auto;
    padding:100;
    position:relative;
    left:32%;
}
</style>