<template>
 <div class="view-container">
   <HeaderNav></HeaderNav>
   <div class="view-wrap live">
     <section class="main-container">
       <LiveNav></LiveNav>
       <!---->
       <div class="content-wrap">
         <ul class="content-list">
           <li class="item" v-for="item in 4" :key="item">
             <LiveItem></LiveItem>
           </li>
         </ul>
       </div>
     </section>
     <!---->
     <!---->
     <aside class="aside-container">
       <LiveTopic></LiveTopic>
     </aside>
   </div>
 </div>
</template>

<script>
  import HeaderNav from './common/header-nav'
  import LiveNav from './live/live-nav'
  import LiveItem from './live/live-item'
  import LiveTopic from './live/live-topic'

  export default {
    name: "live",
    components: {
      HeaderNav,
      LiveNav,
      LiveItem,
      LiveTopic
    }
  }
</script>

<style scoped>
  .content-list .item{
    margin-bottom: 15px;
  }
</style>
