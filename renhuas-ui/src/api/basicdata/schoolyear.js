import request from '@/utils/request'

// 查询学年信息列表
export function listSchoolyear(query) {
  return request({
    url: '/basicdata/schoolyear/list',
    method: 'get',
    params: query
  })
}

// 查询学年信息详细
export function getSchoolyear(schYearId) {
  return request({
    url: '/basicdata/schoolyear/' + schYearId,
    method: 'get'
  })
}

// 新增学年信息
export function addSchoolyear(data) {
  return request({
    url: '/basicdata/schoolyear',
    method: 'post',
    data: data
  })
}

// 修改学年信息
export function updateSchoolyear(data) {
  return request({
    url: '/basicdata/schoolyear',
    method: 'put',
    data: data
  })
}

// 删除学年信息
export function delSchoolyear(schYearId) {
  return request({
    url: '/basicdata/schoolyear/' + schYearId,
    method: 'delete'
  })
}

// 导出学年信息
export function exportSchoolyear(query) {
  return request({
    url: '/basicdata/schoolyear/export',
    method: 'get',
    params: query
  })
}