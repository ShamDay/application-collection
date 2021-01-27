<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="信息名称" prop="sName">
      <el-input v-model="dataForm.sName" placeholder="信息名称"></el-input>
    </el-form-item>
    <el-form-item label="信息类型" prop="sType">
      <el-input v-model="dataForm.sType" placeholder="信息类型"></el-input>
    </el-form-item>
    <el-form-item label="状态" prop="state">
      <template>
        <el-radio v-model="dataForm.state" label="0">生效</el-radio>
        <el-radio v-model="dataForm.state" label="1">失效</el-radio>
      </template>
    </el-form-item>
    <el-form-item label="信息内容" prop="text">
      <el-input v-model="dataForm.text" placeholder="信息内容"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          sId: 0,
          sName: '',
          sType: '',
          state: '',
          createTime: '',
          updateTime: '',
          text: ''
        },
        dataRule: {
          sName: [
            { required: true, message: '信息名称不能为空', trigger: 'blur' }
          ],
          sType: [
            { required: true, message: '信息类型不能为空', trigger: 'blur' }
          ],
          state: [
            { required: true, message: '状态 0生效 1失效不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
          ],
          text: [
            { required: true, message: '信息内容不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.sId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.sId) {
            this.$http({
              url: this.$http.adornUrl(`/account/saveinfo/info/${this.dataForm.sId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.sName = data.saveInfo.sname
                this.dataForm.sType = data.saveInfo.stype
                this.dataForm.state = data.saveInfo.state
                this.dataForm.createTime = data.saveInfo.createTime
                this.dataForm.updateTime = data.saveInfo.updateTime
                this.dataForm.text = data.saveInfo.text
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/account/saveinfo/${!this.dataForm.sId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'sid': this.dataForm.sId || undefined,
                'sname': this.dataForm.sName,
                'stype': this.dataForm.sType,
                'state': this.dataForm.state,
                'text': this.dataForm.text
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
