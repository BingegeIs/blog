import { axios, host } from './base'

const article = {
    createArticleCategory(params) {
        return axios.post(`${host}/api/article/category`, params).then(({ data }) => data)
    },
    getCategory() {
        return axios.get(`${host}/api/article/category`).then(({ data }) => data)
    }
}

export default article
