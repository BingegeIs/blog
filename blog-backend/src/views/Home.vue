<template>
  <el-container style="height: 100vh; border: 1px solid #eee">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
      <el-menu :router="true">
        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-menu"></i>导航
          </template>
          <el-menu-item-group>
            <template slot="title">内容管理</template>
            <el-menu-item index="1-1" route="article">文章管理</el-menu-item>
          </el-menu-item-group>
          <!-- <el-menu-item-group title="账号管理">
            <el-menu-item index="1-3">基本信息</el-menu-item>
          </el-menu-item-group>-->
        </el-submenu>
      </el-menu>
    </el-aside>

    <el-container>
      <el-header style="text-align: right; font-size: 12px">
        <el-dropdown>
          <i class="el-icon-setting" style="margin-right: 15px"></i>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>修改密码</el-dropdown-item>
            <el-dropdown-item>登出</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
        <span>彬哥哥</span>
      </el-header>
      <el-main style="height: 500px">
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {};
</script>

<style>
.el-header {
  background-color: #b3c0d1;
  color: #333;
  line-height: 60px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
.el-aside {
  color: #333;
}

* {
  padding: 0px;
  margin: 0px;
}
</style>
