import request from '@/utils/request'

// 查询学校测评分析列表
export function listSchevalanalyze(query) {
  return request({
    url: '/evalanalyze/schevalanalyze/list',
    method: 'get',
    params: query
  })
}

// 查询学校测评分析详细
export function getSchevalanalyze(analyzeId) {
  return request({
    url: '/evalanalyze/schevalanalyze/' + analyzeId,
    method: 'get'
  })
}

// 新增学校测评分析
export function addSchevalanalyze(data) {
  return request({
    url: '/evalanalyze/schevalanalyze',
    method: 'post',
    data: data
  })
}

// 修改学校测评分析
export function updateSchevalanalyze(data) {
  return request({
    url: '/evalanalyze/schevalanalyze',
    method: 'put',
    data: data
  })
}

// 删除学校测评分析
export function delSchevalanalyze(analyzeId) {
  return request({
    url: '/evalanalyze/schevalanalyze/' + analyzeId,
    method: 'delete'
  })
}

// 导出学校测评分析
export function exportSchevalanalyze(query) {
  return request({
    url: '/evalanalyze/schevalanalyze/export',
    method: 'get',
    params: query
  })
}