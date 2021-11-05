import request from '@/utils/request'

// 查询学生信息列表
export function listSchstudent(query) {
  return request({
    url: '/school/schstudent/list',
    method: 'get',
    params: query
  })
}

// 查询学生信息详细
export function getSchstudent(stuId) {
  return request({
    url: '/school/schstudent/' + stuId,
    method: 'get'
  })
}

// 新增学生信息
export function addSchstudent(data) {
  return request({
    url: '/school/schstudent',
    method: 'post',
    data: data
  })
}

// 修改学生信息
export function updateSchstudent(data) {
  return request({
    url: '/school/schstudent',
    method: 'put',
    data: data
  })
}

// 删除学生信息
export function delSchstudent(stuId) {
  return request({
    url: '/school/schstudent/' + stuId,
    method: 'delete'
  })
}

// 导出学生信息
export function exportSchstudent(query) {
  return request({
    url: '/school/schstudent/export',
    method: 'get',
    params: query
  })
}