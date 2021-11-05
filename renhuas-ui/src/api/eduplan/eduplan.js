import request from '@/utils/request'

// 查询方案管理列表
export function listEduplan(query) {
  return request({
    url: '/eduplan/eduplan/list',
    method: 'get',
    params: query
  })
}

// 查询方案管理详细
export function getEduplan(planId) {
  return request({
    url: '/eduplan/eduplan/' + planId,
    method: 'get'
  })
}

// 新增方案管理
export function addEduplan(data) {
  return request({
    url: '/eduplan/eduplan',
    method: 'post',
    data: data
  })
}

// 修改方案管理
export function updateEduplan(data) {
  return request({
    url: '/eduplan/eduplan',
    method: 'put',
    data: data
  })
}

// 删除方案管理
export function delEduplan(planId) {
  return request({
    url: '/eduplan/eduplan/' + planId,
    method: 'delete'
  })
}

// 导出方案管理
export function exportEduplan(query) {
  return request({
    url: '/eduplan/eduplan/export',
    method: 'get',
    params: query
  })
}