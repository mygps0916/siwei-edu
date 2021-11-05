import request from '@/utils/request'

// 查询学生教学质量追溯列表
export function listStuedutrace(query) {
  return request({
    url: '/edutrace/stuedutrace/list',
    method: 'get',
    params: query
  })
}

// 查询学生教学质量追溯详细
export function getStuedutrace(traceId) {
  return request({
    url: '/edutrace/stuedutrace/' + traceId,
    method: 'get'
  })
}

// 新增学生教学质量追溯
export function addStuedutrace(data) {
  return request({
    url: '/edutrace/stuedutrace',
    method: 'post',
    data: data
  })
}

// 修改学生教学质量追溯
export function updateStuedutrace(data) {
  return request({
    url: '/edutrace/stuedutrace',
    method: 'put',
    data: data
  })
}

// 删除学生教学质量追溯
export function delStuedutrace(traceId) {
  return request({
    url: '/edutrace/stuedutrace/' + traceId,
    method: 'delete'
  })
}

// 导出学生教学质量追溯
export function exportStuedutrace(query) {
  return request({
    url: '/edutrace/stuedutrace/export',
    method: 'get',
    params: query
  })
}