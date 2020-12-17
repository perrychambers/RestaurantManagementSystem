<template>
    <div class="text-cs-center">  
        <v-card outlined>
            <v-card-actions class="justify-center">
                <v-container grid-list-xl>
                        <p>Name of recipe:</p>
                        <v-text-field
                            v-model=newRecipe.name
                        >
                        Name
                        </v-text-field>

                        <p>Calories:</p>
                        <v-text-field
                            v-model=newRecipe.calories
                        >

                        </v-text-field>

                        <p>Price</p>
                        <v-text-field
                            v-model=newRecipe.price
                        >

                        </v-text-field>

                        <p>Ingredients: (component 1, component 2, etc.)</p>
                        <v-text-field v-model=newRecipe.Ingredients></v-text-field>
                    </v-container>
            </v-card-actions>
        </v-card>
        <v-btn outlined @click="addRecipe">Add Recipe</v-btn>

        {{ this.response }}
    </div>
</template>

<script>
import axios from 'axios'
export default {
    data() {
        return {
            newRecipe: {},
            response: ''
        }
    },
    methods: {
        addRecipe() {
            this.newRecipe = {
                name: this.newRecipe.name,
                price: this.newRecipe.price,
                calories: this.newRecipe.calories,
                ingredients: this.newRecipe.ingredientes
            }

            JSON.stringify(this.newRecipe)

            axios.post('http://localhost:8000/recipe/new', this.newRecipe)
            .then((response) => {
                this.response = response.data;
            })
        }
    }
}
</script>
