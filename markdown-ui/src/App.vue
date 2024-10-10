<script setup>
import { ref, onMounted } from 'vue'
import { MdEditor } from 'md-editor-v3';
import 'md-editor-v3/lib/style.css';
import { add, edit, showTitles,showInfo,deleteInfo,search } from '@/api/markdown'
import logo from '@/assets/markdown.png'

const markdownText = ref('')
const markdownTitle = ref('')
const markdownList = ref([])
const markdownId = ref(-1)
const searchText=ref('')
onMounted(() => {
  console.log(window.config.url)
  rereshData()
})
const addmarkdown = () => {
  markdownId.value = -1;
  markdownText.value = '';
  markdownTitle.value = '';
}
const saveValue = () => {
  if (markdownId.value == -1) {
    add({
      title: markdownTitle.value,
      info: markdownText.value
    }).then(res => {
      let data = res.data.data;
      if (data) {
        markdownId.value = data.id;
        rereshData()
      }
    })
  } else {
    edit({
      id: markdownId.value,
      title: markdownTitle.value,
      info: markdownText.value
    }).then(res => {
      let data = res.data.data;
      if (data) {
        markdownId.value = data.id;
        for(let item of markdownList.value)
      {
        if(item.id==data.id)
        {
          item.title=data.title;
          item.info=data.info;
          break;
        }
      }
      }
    })
  }
 
}

const delInfo=()=>{
  deleteInfo(markdownId.value).then(res => {
    rereshData()
    addmarkdown()
  })
  
}

const rereshData = () => {
  showTitles().then(res => {
    let data = res.data.data;
    if (data) {
      markdownList.value = data;
    }
  })
}

const showMarkDown = (id) => {
  markdownId.value = id;
  showInfo(id).then(res => {
    let data = res.data.data;
    if (data) {
      markdownTitle.value = data.title;
      markdownText.value = data.info;
    }
  })
 
}
const searchData=()=>{
   search({keyword:searchText.value}).then(res => {

    let data = res.data.data;
    if (data) {
      markdownList.value = data;
    }
   })
}

</script>

<template>
  <el-container class="page">
    <el-header class="header">
      <img :src="logo" class="logo">
      <el-button type="primary" @click="addmarkdown">新增</el-button>
      <el-button type="primary" @click="saveValue">保存</el-button>
     
      <el-button type="primary" @click="rereshData" >刷新</el-button>
      <el-button type="danger" @click="delInfo">删除</el-button>
      <el-input class="edtSearch" v-model="searchText" placeholder="搜索" @keyup.enter.native="searchData" ></el-input>
    </el-header>
    <el-container class="divClient">
      <el-aside width="200px" class="divLeft">
        <el-scrollbar class="divLeftClient">
          <div v-for="item in markdownList" :key="item.id"
            :class="{ markdownItem: true, isMarkdownItemActive: markdownId == item.id }" 
            @click="showMarkDown(item.id)">{{ item.title }}</div>
        </el-scrollbar>
      </el-aside>
      <el-main class="markdownClient">
        <el-input v-model="markdownTitle" placeholder="输入标题" class="markdownTitle" />
        <MdEditor v-model="markdownText" class="markdown" />

      </el-main>
    </el-container>
  </el-container>
</template>

<style scoped>
.page {
  display: flex;
  flex-direction: column;
  height: 100%;
  width: 100%;
}
.logo{
  width: 32px;
  height: 32px;
  margin-right: 16px;
  cursor: pointer;
 
}
.logo:hover{
  filter: brightness(1.2);
}

.divClient {
  flex: 1;
}
.edtSearch{
  width: 200px;
  position: absolute;
  right: 16px;
  top: 14px;
}

.header {
  background-color: #B3C0D1;
  color: #333;
  text-align: center;
  line-height: 60px;
  display: flex;
  align-items: center;
  justify-content: start;
}

.divLeft {
  background-color: #D3DCE6;
  color: #333;
  height: 100%;
  position: relative;
}

.markdownClient {
  height: 100%;
  display: flex;
  flex-direction: column;
}

.markdownTitle {
  margin-bottom: 8px;

}

.markdown {
  flex: 1;
}

.markdownItem {
  height: 30px;
  line-height: 30px;
  padding-left: 10px;
  cursor: pointer;
}

.markdownItem:hover {
  background-color: #B3C0D1;
}

.isMarkdownItemActive {
  background-color: #97a5b7;
  color: white;
}
.divLeftClient
{
  height: 100%;
  position: absolute;
  width: 100%;
 
}
</style>
