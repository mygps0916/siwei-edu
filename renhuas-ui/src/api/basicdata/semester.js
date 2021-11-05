import request from '@/utils/request'

// 查询学期信息列表
export function listSemester(query) {
  return request({
    url: '/basicdata/semester/list',
    method: 'get',
    params: query
  })
}

// 查询学期信息详细
export function getSemester(semesterId) {
  return request({
    url: '/basicdata/semester/' + semesterId,
    method: 'get'
  })
}

// 新增学期信息
export function addSemester(data) {
  return request({
    url: '/basicdata/semester',
    method: 'post',
    data: data
  })
}

// 修改学期信息
export function updateSemester(data) {
  return request({
    url: '/basicdata/semester',
    method: 'put',
    data: data
  })
}

// 删除学期信息
export function delSemester(semesterId) {
  return request({
    url: '/basicdata/semester/' + semesterId,
    method: 'delete'
  })
}

// 导出学期信息
export function exportSemester(query) {
  return request({
    url: '/basicdata/semester/export',
    method: 'get',
    params: query
  })
}