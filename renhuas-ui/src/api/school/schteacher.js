import request from '@/utils/request'

// 查询教师信息列表
export function listSchteacher(query) {
  return request({
    url: '/school/schteacher/list',
    method: 'get',
    params: query
  })
}

// 查询教师信息详细
export function getSchteacher(teachId) {
  return request({
    url: '/school/schteacher/' + teachId,
    method: 'get'
  })
}

// 新增教师信息
export function addSchteacher(data) {
  return request({
    url: '/school/schteacher',
    method: 'post',
    data: data
  })
}

// 修改教师信息
export function updateSchteacher(data) {
  return request({
    url: '/school/schteacher',
    method: 'put',
    data: data
  })
}

// 删除教师信息
export function delSchteacher(teachId) {
  return request({
    url: '/school/schteacher/' + teachId,
    method: 'delete'
  })
}

// 导出教师信息
export function exportSchteacher(query) {
  return request({
    url: '/school/schteacher/export',
    method: 'get',
    params: query
  })
}