import request from '@/utils/request'

// 查询数据管理列表
export function listDatainform(query) {
  return request({
    url: '/datainform/datainform/list',
    method: 'get',
    params: query
  })
}

// 查询数据管理详细
export function getDatainform(inforId) {
  return request({
    url: '/datainform/datainform/' + inforId,
    method: 'get'
  })
}

// 新增数据管理
export function addDatainform(data) {
  return request({
    url: '/datainform/datainform',
    method: 'post',
    data: data
  })
}

// 修改数据管理
export function updateDatainform(data) {
  return request({
    url: '/datainform/datainform',
    method: 'put',
    data: data
  })
}

// 删除数据管理
export function delDatainform(inforId) {
  return request({
    url: '/datainform/datainform/' + inforId,
    method: 'delete'
  })
}

// 导出数据管理
export function exportDatainform(query) {
  return request({
    url: '/datainform/datainform/export',
    method: 'get',
    params: query
  })
}