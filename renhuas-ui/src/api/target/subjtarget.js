import request from '@/utils/request'

// 查询主观指标列表
export function listSubjtarget(query) {
  return request({
    url: '/target/subjtarget/list',
    method: 'get',
    params: query
  })
}

// 查询主观指标详细
export function getSubjtarget(tarId) {
  return request({
    url: '/target/subjtarget/' + tarId,
    method: 'get'
  })
}

// 新增主观指标
export function addSubjtarget(data) {
  return request({
    url: '/target/subjtarget',
    method: 'post',
    data: data
  })
}

// 修改主观指标
export function updateSubjtarget(data) {
  return request({
    url: '/target/subjtarget',
    method: 'put',
    data: data
  })
}

// 删除主观指标
export function delSubjtarget(tarId) {
  return request({
    url: '/target/subjtarget/' + tarId,
    method: 'delete'
  })
}

// 导出主观指标
export function exportSubjtarget(query) {
  return request({
    url: '/target/subjtarget/export',
    method: 'get',
    params: query
  })
}