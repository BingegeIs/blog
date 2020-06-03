import Router from 'vue-router'
import Vue from 'vue'

Vue.use(Router)

const router = new Router({
    routes: [
        {
            path: '/',
            name: 'default',
            component: () => import('./views/Home.vue'),
            children: [
                {
                    path: '',
                    component: () => import('./views/Welcome.vue')
                },
                {
                    path: 'article',
                    component: () => import('./views/Article.vue')
                }
            ]
        },
        {
            path: '/login',
            name: 'login',
            component: () => import('./views/Login.vue')
        }
    ]
})

export default router
