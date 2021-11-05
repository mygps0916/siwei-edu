import request from '@/utils/request'

// 查询老师测评分析列表
export function listTeachevalanalyze(query) {
  return request({
    url: '/evalanalyze/teachevalanalyze/list',
    method: 'get',
    params: query
  })
}

// 查询老师测评分析详细
export function getTeachevalanalyze(analyzeId) {
  return request({
    url: '/evalanalyze/teachevalanalyze/' + analyzeId,
    method: 'get'
  })
}

// 新增老师测评分析
export function addTeachevalanalyze(data) {
  return request({
    url: '/evalanalyze/teachevalanalyze',
    method: 'post',
    data: data
  })
}

// 修改老师测评分析
export function updateTeachevalanalyze(data) {
  return request({
    url: '/evalanalyze/teachevalanalyze',
    method: 'put',
    data: data
  })
}

// 删除老师测评分析
export function delTeachevalanalyze(analyzeId) {
  return request({
    url: '/evalanalyze/teachevalanalyze/' + analyzeId,
    method: 'delete'
  })
}

// 导出老师测评分析
export function exportTeachevalanalyze(query) {
  return request({
    url: '/evalanalyze/teachevalanalyze/export',
    method: 'get',
    params: query
  })
}