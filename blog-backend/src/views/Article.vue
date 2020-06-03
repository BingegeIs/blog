<template>
    <el-table
      style="width: 100%">
      <el-table-column
        prop="date"
        label="日期"
        width="180">
      </el-table-column>
    </el-table>
</template>

<script>
import $api from '@/network/article'

export default {
    created: function() {
            return $api.getCategory().then(res => {
                return res.data
            })
    }
}
</script>