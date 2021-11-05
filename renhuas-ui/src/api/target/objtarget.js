import request from '@/utils/request'

// 查询客观指标列表
export function listObjtarget(query) {
  return request({
    url: '/target/objtarget/list',
    method: 'get',
    params: query
  })
}

// 查询客观指标详细
export function getObjtarget(tarId) {
  return request({
    url: '/target/objtarget/' + tarId,
    method: 'get'
  })
}

// 新增客观指标
export function addObjtarget(data) {
  return request({
    url: '/target/objtarget',
    method: 'post',
    data: data
  })
}

// 修改客观指标
export function updateObjtarget(data) {
  return request({
    url: '/target/objtarget',
    method: 'put',
    data: data
  })
}

// 删除客观指标
export function delObjtarget(tarId) {
  return request({
    url: '/target/objtarget/' + tarId,
    method: 'delete'
  })
}

// 导出客观指标
export function exportObjtarget(query) {
  return request({
    url: '/target/objtarget/export',
    method: 'get',
    params: query
  })
}