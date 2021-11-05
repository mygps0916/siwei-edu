import request from '@/utils/request'

// 查询教学质量评测列表
export function listEduqualityeval(query) {
  return request({
    url: '/evaluation/eduqualityeval/list',
    method: 'get',
    params: query
  })
}

// 查询教学质量评测详细
export function getEduqualityeval(techQualityId) {
  return request({
    url: '/evaluation/eduqualityeval/' + techQualityId,
    method: 'get'
  })
}

// 新增教学质量评测
export function addEduqualityeval(data) {
  return request({
    url: '/evaluation/eduqualityeval',
    method: 'post',
    data: data
  })
}

// 修改教学质量评测
export function updateEduqualityeval(data) {
  return request({
    url: '/evaluation/eduqualityeval',
    method: 'put',
    data: data
  })
}

// 删除教学质量评测
export function delEduqualityeval(techQualityId) {
  return request({
    url: '/evaluation/eduqualityeval/' + techQualityId,
    method: 'delete'
  })
}

// 导出教学质量评测
export function exportEduqualityeval(query) {
  return request({
    url: '/evaluation/eduqualityeval/export',
    method: 'get',
    params: query
  })
}