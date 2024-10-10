import axios from "axios";

const instance=axios.create({
    baseURL:window.config.url,
   
});
export default instance;