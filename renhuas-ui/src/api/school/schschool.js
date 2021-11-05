import request from '@/utils/request'

// 查询学校信息列表
export function listSchschool(query) {
  return request({
    url: '/school/schschool/list',
    method: 'get',
    params: query
  })
}

// 查询学校信息详细
export function getSchschool(schId) {
  return request({
    url: '/school/schschool/' + schId,
    method: 'get'
  })
}

// 新增学校信息
export function addSchschool(data) {
  return request({
    url: '/school/schschool',
    method: 'post',
    data: data
  })
}

// 修改学校信息
export function updateSchschool(data) {
  return request({
    url: '/school/schschool',
    method: 'put',
    data: data
  })
}

// 删除学校信息
export function delSchschool(schId) {
  return request({
    url: '/school/schschool/' + schId,
    method: 'delete'
  })
}

// 导出学校信息
export function exportSchschool(query) {
  return request({
    url: '/school/schschool/export',
    method: 'get',
    params: query
  })
}