import { createApp } from "vue";
import App from "./App.vue";
import ArcoVue from "@arco-design/web-vue";
import { createPinia } from "pinia";
import "@arco-design/web-vue/dist/arco.css";
import "@/access";
import router from "./router";

const pinia = createPinia();
createApp(App).use(router).use(pinia).use(ArcoVue).mount("#app");
