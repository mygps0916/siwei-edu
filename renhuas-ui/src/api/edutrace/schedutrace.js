import request from '@/utils/request'

// 查询学校教学追溯列表
export function listSchedutrace(query) {
  return request({
    url: '/edutrace/schedutrace/list',
    method: 'get',
    params: query
  })
}

// 查询学校教学追溯详细
export function getSchedutrace(traceId) {
  return request({
    url: '/edutrace/schedutrace/' + traceId,
    method: 'get'
  })
}

// 新增学校教学追溯
export function addSchedutrace(data) {
  return request({
    url: '/edutrace/schedutrace',
    method: 'post',
    data: data
  })
}

// 修改学校教学追溯
export function updateSchedutrace(data) {
  return request({
    url: '/edutrace/schedutrace',
    method: 'put',
    data: data
  })
}

// 删除学校教学追溯
export function delSchedutrace(traceId) {
  return request({
    url: '/edutrace/schedutrace/' + traceId,
    method: 'delete'
  })
}

// 导出学校教学追溯
export function exportSchedutrace(query) {
  return request({
    url: '/edutrace/schedutrace/export',
    method: 'get',
    params: query
  })
}