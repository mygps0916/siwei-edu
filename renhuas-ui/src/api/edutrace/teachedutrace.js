import request from '@/utils/request'

// 查询老师教学追溯列表
export function listTeachedutrace(query) {
  return request({
    url: '/edutrace/teachedutrace/list',
    method: 'get',
    params: query
  })
}

// 查询老师教学追溯详细
export function getTeachedutrace(traceId) {
  return request({
    url: '/edutrace/teachedutrace/' + traceId,
    method: 'get'
  })
}

// 新增老师教学追溯
export function addTeachedutrace(data) {
  return request({
    url: '/edutrace/teachedutrace',
    method: 'post',
    data: data
  })
}

// 修改老师教学追溯
export function updateTeachedutrace(data) {
  return request({
    url: '/edutrace/teachedutrace',
    method: 'put',
    data: data
  })
}

// 删除老师教学追溯
export function delTeachedutrace(traceId) {
  return request({
    url: '/edutrace/teachedutrace/' + traceId,
    method: 'delete'
  })
}

// 导出老师教学追溯
export function exportTeachedutrace(query) {
  return request({
    url: '/edutrace/teachedutrace/export',
    method: 'get',
    params: query
  })
}