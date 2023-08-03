import axios from 'axios'

const instance = axios.create({
  baseURL: import.meta.env.VITE_BASE_URL,
  headers: {
    //'Content-Type': 'application/json',
    'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8;',
  },
})

instance.interceptors.request.use(
  config => {
    console.log('[ axios-request ] : ', config)
    return config
  },
  error => {
    return Promise.reject(error)
  },
)
instance.interceptors.response.use(
  res => {
    console.log('[ axios-response ] : ', res)
    return res
  },
  error => {
    return Promise.reject(error)
  },
)
export default instance
