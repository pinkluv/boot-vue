<template>
  <div class="div">Update Home View....</div>
</template>

<script setup>
import { onMounted, inject } from 'vue'

const axios = inject('$axios')

onMounted(async () => {
  console.log('AboutView onMounted.....')
  //await axios.get('/api/test').then(data => console.log(data))

  const params = {
    id: 12,
    name: 'tommy',
    description: 'Kim Young Ho',
    address: 'Seoul Korea',
    active: true,
  }

  await axios
    .get('/api/sample/PathVariable/test/12')
    .then(result => console.log(result))

  await axios
    .get('/api/sample/RequestParam', { params })
    .then(result => console.log(result))

  await axios
    .get('/api/sample/RequestParamMap', { params })
    .then(result => console.log(result))

  const paramss2 = {
    arr: [1, 2, 3, 4],
  }

  await axios
    .post('/api/sample/RequestParamArr', paramss2)
    .then(result => console.log(result))

  await axios
    .post('/api/sample/ModelAttribute', params, {
      headers: {
        'Content-Type': `application/x-www-form-urlencoded; charset=UTF-8;`,
      },
    })
    .then(result => console.log(result))

  await axios
    .post('/api/sample/RequestBody', JSON.stringify(params), {
      headers: { 'Content-Type': `application/json` },
    })
    .then(result => console.log(result))

  const paramsArr = [params, params, params, params]

  await axios
    .post('/api/sample/RequestBodyList', JSON.stringify(paramsArr), {
      headers: { 'Content-Type': `application/json` },
    })
    .then(result => console.log(result))
})
</script>
