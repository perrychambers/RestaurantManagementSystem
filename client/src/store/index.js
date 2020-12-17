import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);

export const store = new Vuex.Store({
    state: {
        cart: {},
        total: 0
    },
    getters: {
        getCart: state => state.cart,
        getTotal: total => state.total
    },
    mutations: {
        addToCart(state, item) {
            this.state.cart.push(item)
            // calculate total
            var total = this.state.total
            total += item.price
        }
    }
})