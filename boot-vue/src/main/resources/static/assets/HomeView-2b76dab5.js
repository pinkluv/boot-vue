import{i as n,u as i,j as p,k as l}from"./@vue-5537a947.js";const r={class:"div"},d={__name:"HomeView",setup(c){const o=n("$axios");return i(async()=>{console.log("AboutView onMounted.....");const a={id:12,name:"tommy",description:"Kim Young Ho",address:"Seoul Korea",active:!0};await o.get("/api/sample/PathVariable/test/12").then(e=>console.log(e)),await o.get("/api/sample/RequestParam",{params:a}).then(e=>console.log(e)),await o.get("/api/sample/RequestParamMap",{params:a}).then(e=>console.log(e));const t={arr:[1,2,3,4]};await o.post("/api/sample/RequestParamArr",t).then(e=>console.log(e)),await o.post("/api/sample/ModelAttribute",a,{headers:{"Content-Type":"application/x-www-form-urlencoded; charset=UTF-8;"}}).then(e=>console.log(e)),await o.post("/api/sample/RequestBody",JSON.stringify(a),{headers:{"Content-Type":"application/json"}}).then(e=>console.log(e));const s=[a,a,a,a];await o.post("/api/sample/RequestBodyList",JSON.stringify(s),{headers:{"Content-Type":"application/json"}}).then(e=>console.log(e))}),(a,t)=>(p(),l("div",r,"Update Home View...."))}};export{d as default};
