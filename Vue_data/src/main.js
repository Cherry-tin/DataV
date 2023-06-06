import { createApp } from 'vue'
import DataV from './DataV.vue'
import router from './router'
//导入element-plus组件
import elementplus from 'element-plus'
import 'element-plus/dist/index.css'

createApp(DataV).use(elementplus).use(router).mount('#app')
