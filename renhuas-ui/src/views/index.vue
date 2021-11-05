<template>
  <div class="app-container home">
    <div class="row">
      <div class="col-lg-12 chat-sidebar">

        <!-- begin::chat sidebar search -->
        <div class="chat-sidebar-header">
          <ul class="nav nav-tabs" id="pills-tab" role="tablist">
            <li class="nav-item">
              <a class="nav-link active" id="xiaoxue-home-tab" data-toggle="pill" href="#xiaoxue-home" role="tab" aria-controls="xiaoxue-home" aria-selected="false">小学概览</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" id="zhongxue-home-tab" data-toggle="pill" href="#zhongxue-home" role="tab" aria-controls="zhongxue-home" aria-selected="true">中学概览</a>
            </li>
          </ul>
        </div>
        <!-- begin::chat sidebar search -->

        <!-- end::chat list -->
        <div class="chat-sidebar-content" tabindex="1" style="overflow: hidden; outline: none;">
          <div class="tab-content pt-3" id="pills-tabContent">
            <div class="tab-pane fade active show" id="xiaoxue-home" role="tabpanel" aria-labelledby="xiaoxue-home-tab">
              <div class="row">
                <div class="col-md-3">
                  <div class="card">
                    <div class="card-header">
                      <div class="row">
                        <div class="col-md-4">
                          <select class="form-control">
                            <option>学年</option>
                            <option value="1">2020/2021</option>
                            <option value="2">2019/2020</option>
                          </select>
                        </div>
                        <div class="col-md-4">
                          <select class="form-control">
                            <option>学期</option>
                            <option value="1">第一学期</option>
                            <option value="2">第二学期</option>
                          </select>
                        </div>
                        <div class="col-md-4">
                          <select class="form-control">
                            <option>年级</option>
                            <option value="1">一年级</option>
                            <option value="2">二年级</option>
                          </select>
                        </div>
                      </div>
                    </div>
                    <div class="card-body">
                      <div class="row align-content-center">
                        <div class="col-md-2"></div>
                        <div class="col-md-2"><input value="语文" type="button" class="btn btn-sm btn-outline-primary btn-pulse"></div>
                        <div class="col-md-2"><input value="数学" type="button" class="btn btn-sm btn-outline-primary btn-pulse"></div>
                        <div class="col-md-2"><input value="英语" type="button" class="btn btn-sm btn-outline-primary btn-pulse"></div>
                      </div>
                    </div>

                  </div>
                  <div class="card">
                    <div class="card-header">学校成绩四率</div>
                    <div class="card-body">
                      <div class="row">
                        <div class="col-md-12">
                          <div class="table-responsive" style="overflow: auto">
                            <table class="table table-striped" style="white-space: nowrap">
                              <thead>
                              <tr>
                                <th scope="col">学校名称</th>
                                <th scope="col">优秀</th>
                                <th scope="col">良好</th>
                                <th scope="col">及格</th>
                                <th scope="col">低分</th>
                              </tr>
                              </thead>
                              <tbody>
                              <tr>
                                <td>科宝外语学校</td>
                                <td>16%</td>
                                <td>66%</td>
                                <td>33%</td>
                                <td>18%</td>
                              </tr>
                              <tr>
                                <td>科宝外语学校</td>
                                <td>16%</td>
                                <td>66%</td>
                                <td>33%</td>
                                <td>18%</td>
                              </tr>
                              <tr>
                                <td>科宝外语学校</td>
                                <td>16%</td>
                                <td>66%</td>
                                <td>33%</td>
                                <td>18%</td>
                              </tr>
                              <tr>
                                <td>科宝外语学校</td>
                                <td>16%</td>
                                <td>66%</td>
                                <td>33%</td>
                                <td>18%</td>
                              </tr>
                              <tr>
                                <td>科宝外语学校</td>
                                <td>16%</td>
                                <td>66%</td>
                                <td>33%</td>
                                <td>18%</td>
                              </tr>
                              </tbody>
                            </table>
                            <nav aria-label="Page navigation example">
                              <ul class="pagination justify-content-end">
                                <li class="page-item disabled">
                                  <a class="page-link" href="#" tabindex="-1" aria-disabled="true">上一页</a>
                                </li>
                                <li class="page-item">
                                  <a class="page-link" href="#">下一页</a>
                                </li>
                              </ul>
                            </nav>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="card">
                    <div class="card-header">区学生成绩正态分布统计</div>
                    <div class="card-body">
                      <div class="row">
                        <div class="col-md-6"><span>参考人数：</span><span>362人</span></div>
                        <div class="col-md-6"><span>零分人数：</span><span>362人</span></div>
                        <div class="col-md-6"><span>最高分：</span><span>362分</span></div>
                        <div class="col-md-6"><span>最低分：</span><span>362分</span></div>
                        <div class="col-md-6"><span>中间数：</span><span>362分</span></div>
                        <div class="col-md-6"><span>标准差：</span><span>362人</span></div>
                        <div class="col-md-6"><span>组数：</span><span>362</span></div>
                        <div class="col-md-6"><span>组距：</span><span>362人</span></div>
                      </div><hr>
                      <div class="row">
                        <div class="col-md-12">
                          <div class="table-responsive" style="overflow: auto">
                            <table class="table table-striped" style="white-space: nowrap">
                              <thead>
                              <tr>
                                <th scope="col">序号</th>
                                <th scope="col">正太值</th>
                                <th scope="col">分数段</th>
                                <th scope="col">人数</th>
                              </tr>
                              </thead>
                              <tbody>
                              <tr>
                                <td>1</td>
                                <td>0.001661747</td>
                                <td>0-61.10</td>
                                <td>62</td>
                              </tr>
                              <tr>
                                <td>1</td>
                                <td>0.001661747</td>
                                <td>0-61.10</td>
                                <td>62</td>
                              </tr>
                              <tr>
                                <td>1</td>
                                <td>0.001661747</td>
                                <td>0-61.10</td>
                                <td>62</td>
                              </tr>
                              <tr>
                                <td>1</td>
                                <td>0.001661747</td>
                                <td>0-61.10</td>
                                <td>62</td>
                              </tr>
                              <tr>
                                <td>1</td>
                                <td>0.001661747</td>
                                <td>0-61.10</td>
                                <td>62</td>
                              </tr>
                              <tr>
                                <td>1</td>
                                <td>0.001661747</td>
                                <td>0-61.10</td>
                                <td>62</td>
                              </tr>
                              </tbody>
                            </table>
                            <nav aria-label="Page navigation example">
                              <ul class="pagination justify-content-end">
                                <li class="page-item disabled">
                                  <a class="page-link" href="#" tabindex="-1" aria-disabled="true">上一页</a>
                                </li>
                                <li class="page-item">
                                  <a class="page-link" href="#">下一页</a>
                                </li>
                              </ul>
                            </nav>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-md-5">
                  <div class="card">
                    <div class="card-header">区近5年各科目平均分</div>
                    <div class="card-body">
                      <div id="x-kemupingjun" style="height: 275px"></div>
                    </div>
                  </div>
                  <div class="card">
                    <div class="card-header">本学期学校各科目平均分</div>
                    <div class="card-body">
                      <div id="x-silvtu" style="height: 250px"></div>
                    </div>
                  </div>
                  <div class="card">
                    <div class="card-header">本学期平均分对比波动</div>
                    <div class="card-body">
                      <div id="x-pingjunfenduibi" style="height: 250px"></div>
                    </div>
                  </div>
                </div>
                <div class="col-md-4">
                  <div class="card">
                    <div class="card-header"><span>本学期教师区内前10名（排名不分学科）</span>
                      <span><a style="float: right" href="#" class="text-primary">查看详情</a></span></div>
                    <div class="card-body">
                      <div class="row">
                        <div class="col-md-12">
                          <div class="table-responsive" style="overflow: auto">
                            <table class="table table-striped" style="white-space: nowrap">
                              <thead>
                              <tr>
                                <th scope="col">名称</th>
                                <th scope="col">身份证号</th>
                                <th scope="col">所属学校</th>
                                <th scope="col">得分</th>
                                <th scope="col">排名</th>
                                <th scope="col">科目</th>
                              </tr>
                              </thead>
                              <tbody>
                              <tr>
                                <td>王李四</td>
                                <td>46**4213</td>
                                <td>科宝外语学校</td>
                                <td>100</td>
                                <td>1</td>
                                <td>语文</td>
                              </tr>
                              <tr>
                                <td>王李四</td>
                                <td>46**4213</td>
                                <td>科宝外语学校</td>
                                <td>100</td>
                                <td>10</td>
                                <td>语文</td>
                              </tr>
                              <tr>
                                <td>王李四</td>
                                <td>46**4213</td>
                                <td>科宝外语学校</td>
                                <td>100</td>
                                <td>10</td>
                                <td>语文</td>
                              </tr>
                              <tr>
                                <td>王李四</td>
                                <td>46**4213</td>
                                <td>科宝外语学校</td>
                                <td>100</td>
                                <td>10</td>
                                <td>语文</td>
                              </tr>
                              <tr>
                                <td>王李四</td>
                                <td>46**4213</td>
                                <td>科宝外语学校</td>
                                <td>100</td>
                                <td>10</td>
                                <td>语文</td>
                              </tr>
                              <tr>
                                <td>王李四</td>
                                <td>46**4213</td>
                                <td>科宝外语学校</td>
                                <td>100</td>
                                <td>10</td>
                                <td>语文</td>
                              </tr>
                              <tr>
                                <td>王李四</td>
                                <td>46**4213</td>
                                <td>科宝外语学校</td>
                                <td>100</td>
                                <td>10</td>
                                <td>语文</td>
                              </tr>
                              <tr>
                                <td>王李四</td>
                                <td>46**4213</td>
                                <td>科宝外语学校</td>
                                <td>100</td>
                                <td>10</td>
                                <td>语文</td>
                              </tr>
                              <tr>
                                <td>王李四</td>
                                <td>46**4213</td>
                                <td>科宝外语学校</td>
                                <td>100</td>
                                <td>10</td>
                                <td>语文</td>
                              </tr>
                              <tr>
                                <td>王李四</td>
                                <td>46**4213</td>
                                <td>科宝外语学校</td>
                                <td>100</td>
                                <td>10</td>
                                <td>语文</td>
                              </tr>
                              </tbody>
                            </table>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="card">
                    <div class="card-header">本学期平均分增幅排名</div>
                    <div class="card-body">
                      <div class="row">
                        <div class="col-md-12">
                          <div class="table-responsive" style="overflow: auto">
                            <table class="table table-striped" style="white-space: nowrap">
                              <thead>
                              <tr>
                                <th scope="col">序号</th>
                                <th scope="col">学校名称</th>
                                <th scope="col">语文</th>
                                <th scope="col">排名</th>
                                <th scope="col">数学</th>
                                <th scope="col">排名</th>
                                <th scope="col">英语</th>
                                <th scope="col">排名</th>
                              </tr>
                              </thead>
                              <tbody>
                              <tr>
                                <td>1</td>
                                <td>科宝外语学校</td>
                                <td>66%</td>
                                <td>10</td>
                                <td>18%</td>
                                <td>1</td>
                                <td>1%</td>
                                <td>78</td>
                              </tr>
                              <tr>
                                <td>1</td>
                                <td>科宝外语学校</td>
                                <td>66%</td>
                                <td>10</td>
                                <td>18%</td>
                                <td>1</td>
                                <td>1%</td>
                                <td>78</td>
                              </tr>
                              <tr>
                                <td>1</td>
                                <td>科宝外语学校</td>
                                <td>66%</td>
                                <td>10</td>
                                <td>18%</td>
                                <td>1</td>
                                <td>1%</td>
                                <td>78</td>
                              </tr>
                              <tr>
                                <td>1</td>
                                <td>科宝外语学校</td>
                                <td>66%</td>
                                <td>10</td>
                                <td>18%</td>
                                <td>1</td>
                                <td>1%</td>
                                <td>78</td>
                              </tr>
                              <tr>
                                <td>1</td>
                                <td>科宝外语学校</td>
                                <td>66%</td>
                                <td>10</td>
                                <td>18%</td>
                                <td>1</td>
                                <td>1%</td>
                                <td>78</td>
                              </tr>
                              <tr>
                                <td>1</td>
                                <td>科宝外语学校</td>
                                <td>66%</td>
                                <td>10</td>
                                <td>18%</td>
                                <td>1</td>
                                <td>1%</td>
                                <td>78</td>
                              </tr>
                              <tr>
                                <td>1</td>
                                <td>科宝外语学校</td>
                                <td>66%</td>
                                <td>10</td>
                                <td>18%</td>
                                <td>1</td>
                                <td>1%</td>
                                <td>78</td>
                              </tr>
                              <tr>
                                <td>1</td>
                                <td>科宝外语学校</td>
                                <td>66%</td>
                                <td>10</td>
                                <td>18%</td>
                                <td>1</td>
                                <td>1%</td>
                                <td>78</td>
                              </tr>
                              <tr>
                                <td>1</td>
                                <td>科宝外语学校</td>
                                <td>66%</td>
                                <td>10</td>
                                <td>18%</td>
                                <td>1</td>
                                <td>1%</td>
                                <td>78</td>
                              </tr>
                              </tbody>
                            </table>
                            <nav aria-label="Page navigation example">
                              <ul class="pagination justify-content-end">
                                <li class="page-item disabled">
                                  <a class="page-link" href="#" tabindex="-1" aria-disabled="true">上一页</a>
                                </li>
                                <li class="page-item">
                                  <a class="page-link" href="#">下一页</a>
                                </li>
                              </ul>
                            </nav>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="tab-pane fade active" id="zhongxue-home" role="tabpanel" aria-labelledby="zhongxue-home-tab">
              <div class="row">
                <div class="col-md-3">
                  <div class="card">
                    <div class="card-header">
                      <div class="row">
                        <div class="col-md-4">
                          <div class="dropdown">
                            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                              当前学年
                            </button>
                            <div class="dropdown-menu">
                              <a class="dropdown-item" href="#">2021学年</a>
                              <a class="dropdown-item" href="#">2020学年</a>
                              <a class="dropdown-item" href="#">2019学年</a>
                            </div>
                          </div>
                        </div>
                        <div class="col-md-4">
                          <div class="dropdown">
                            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                              当前学期
                            </button>
                            <div class="dropdown-menu">
                              <a class="dropdown-item" href="#">第一学期</a>
                              <a class="dropdown-item" href="#">第二学期</a>
                            </div>
                          </div>
                        </div>
                        <div class="col-md-4">
                          <div class="dropdown">
                            <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
                              年级
                            </button>
                            <div class="dropdown-menu">
                              <a class="dropdown-item" href="#">一年级</a>
                              <a class="dropdown-item" href="#">二年级</a>
                              <a class="dropdown-item" href="#">三年级</a>
                              <a class="dropdown-item" href="#">四年级</a>
                              <a class="dropdown-item" href="#">五年级</a>
                              <a class="dropdown-item" href="#">六年级</a>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="card-body">
                      <div class="row align-content-center">
                        <div class="col-md-2"></div>
                        <div class="col-md-2"><input value="语文" type="button" class="btn btn-sm btn-outline-primary btn-pulse"></div>
                        <div class="col-md-2"><input value="数学" type="button" class="btn btn-sm btn-outline-primary btn-pulse"></div>
                        <div class="col-md-2"><input value="英语" type="button" class="btn btn-sm btn-outline-primary btn-pulse"></div>
                      </div>
                    </div>

                  </div>
                  <div class="card">
                    <div class="card-header">学校成绩四率</div>
                    <div class="card-body">
                      <div class="row">
                        <div class="col-md-12">
                          <div class="table-responsive" style="overflow: auto">
                            <table class="table table-striped" style="white-space: nowrap">
                              <thead>
                              <tr>
                                <th scope="col">学校名称</th>
                                <th scope="col">优秀</th>
                                <th scope="col">良好</th>
                                <th scope="col">及格</th>
                                <th scope="col">低分</th>
                              </tr>
                              </thead>
                              <tbody>
                              <tr>
                                <td>科宝外语学校</td>
                                <td>16%</td>
                                <td>66%</td>
                                <td>33%</td>
                                <td>18%</td>
                              </tr>
                              <tr>
                                <td>科宝外语学校</td>
                                <td>16%</td>
                                <td>66%</td>
                                <td>33%</td>
                                <td>18%</td>
                              </tr>
                              <tr>
                                <td>科宝外语学校</td>
                                <td>16%</td>
                                <td>66%</td>
                                <td>33%</td>
                                <td>18%</td>
                              </tr>
                              <tr>
                                <td>科宝外语学校</td>
                                <td>16%</td>
                                <td>66%</td>
                                <td>33%</td>
                                <td>18%</td>
                              </tr>
                              <tr>
                                <td>科宝外语学校</td>
                                <td>16%</td>
                                <td>66%</td>
                                <td>33%</td>
                                <td>18%</td>
                              </tr>
                              </tbody>
                            </table>
                            <nav aria-label="Page navigation example">
                              <ul class="pagination justify-content-end">
                                <li class="page-item disabled">
                                  <a class="page-link" href="#" tabindex="-1" aria-disabled="true">上一页</a>
                                </li>
                                <li class="page-item">
                                  <a class="page-link" href="#">下一页</a>
                                </li>
                              </ul>
                            </nav>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="card">
                    <div class="card-header">区学生成绩正态分布统计</div>
                    <div class="card-body">
                      <div class="row">
                        <div class="col-md-6"><span>参考人数：</span><span>362人</span></div>
                        <div class="col-md-6"><span>零分人数：</span><span>362人</span></div>
                        <div class="col-md-6"><span>最高分：</span><span>362分</span></div>
                        <div class="col-md-6"><span>最低分：</span><span>362分</span></div>
                        <div class="col-md-6"><span>中间数：</span><span>362分</span></div>
                        <div class="col-md-6"><span>标准差：</span><span>362人</span></div>
                        <div class="col-md-6"><span>组数：</span><span>362</span></div>
                        <div class="col-md-6"><span>组距：</span><span>362人</span></div>
                      </div><hr>
                      <div class="row">
                        <div class="col-md-12">
                          <div class="table-responsive" style="overflow: auto">
                            <table class="table table-striped" style="white-space: nowrap">
                              <thead>
                              <tr>
                                <th scope="col">序号</th>
                                <th scope="col">正太值</th>
                                <th scope="col">分数段</th>
                                <th scope="col">人数</th>
                              </tr>
                              </thead>
                              <tbody>
                              <tr>
                                <td>1</td>
                                <td>0.001661747</td>
                                <td>0-61.10</td>
                                <td>62</td>
                              </tr>
                              <tr>
                                <td>1</td>
                                <td>0.001661747</td>
                                <td>0-61.10</td>
                                <td>62</td>
                              </tr>
                              <tr>
                                <td>1</td>
                                <td>0.001661747</td>
                                <td>0-61.10</td>
                                <td>62</td>
                              </tr>
                              <tr>
                                <td>1</td>
                                <td>0.001661747</td>
                                <td>0-61.10</td>
                                <td>62</td>
                              </tr>
                              <tr>
                                <td>1</td>
                                <td>0.001661747</td>
                                <td>0-61.10</td>
                                <td>62</td>
                              </tr>
                              <tr>
                                <td>1</td>
                                <td>0.001661747</td>
                                <td>0-61.10</td>
                                <td>62</td>
                              </tr>
                              </tbody>
                            </table>
                            <nav aria-label="Page navigation example">
                              <ul class="pagination justify-content-end">
                                <li class="page-item disabled">
                                  <a class="page-link" href="#" tabindex="-1" aria-disabled="true">上一页</a>
                                </li>
                                <li class="page-item">
                                  <a class="page-link" href="#">下一页</a>
                                </li>
                              </ul>
                            </nav>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="col-md-5">
                  <div class="card">
                    <div class="card-header">区近5年各科目平均分</div>
                    <div class="card-body">
                      <div id="z-kemupingjun" style="height: 275px"></div>
                    </div>
                  </div>
                  <div class="card">
                    <div class="card-header">本学期学校各科目平均分</div>
                    <div class="card-body">
                      <div id="z-silvtu" style="height: 250px"></div>
                    </div>
                  </div>
                  <div class="card">
                    <div class="card-header">本学期平均分对比波动</div>
                    <div class="card-body">
                      <div id="z-pingjunfenduibi" style="height: 250px"></div>
                    </div>
                  </div>
                </div>
                <div class="col-md-4">
                  <div class="card">
                    <div class="card-header"><span>本学期教师区内前10名（排名不分学科）</span>
                      <span><a style="float: right" href="#" class="text-primary">查看详情</a></span></div>
                    <div class="card-body">
                      <div class="row">
                        <div class="col-md-12">
                          <div class="table-responsive" style="overflow: auto">
                            <table class="table table-striped" style="white-space: nowrap">
                              <thead>
                              <tr>
                                <th scope="col">名称</th>
                                <th scope="col">身份证号</th>
                                <th scope="col">所属学校</th>
                                <th scope="col">得分</th>
                                <th scope="col">排名</th>
                                <th scope="col">科目</th>
                              </tr>
                              </thead>
                              <tbody>
                              <tr>
                                <td>王李四</td>
                                <td>46**4213</td>
                                <td>科宝外语学校</td>
                                <td>100</td>
                                <td>1</td>
                                <td>语文</td>
                              </tr>
                              <tr>
                                <td>王李四</td>
                                <td>46**4213</td>
                                <td>科宝外语学校</td>
                                <td>100</td>
                                <td>10</td>
                                <td>语文</td>
                              </tr>
                              <tr>
                                <td>王李四</td>
                                <td>46**4213</td>
                                <td>科宝外语学校</td>
                                <td>100</td>
                                <td>10</td>
                                <td>语文</td>
                              </tr>
                              <tr>
                                <td>王李四</td>
                                <td>46**4213</td>
                                <td>科宝外语学校</td>
                                <td>100</td>
                                <td>10</td>
                                <td>语文</td>
                              </tr>
                              <tr>
                                <td>王李四</td>
                                <td>46**4213</td>
                                <td>科宝外语学校</td>
                                <td>100</td>
                                <td>10</td>
                                <td>语文</td>
                              </tr>
                              <tr>
                                <td>王李四</td>
                                <td>46**4213</td>
                                <td>科宝外语学校</td>
                                <td>100</td>
                                <td>10</td>
                                <td>语文</td>
                              </tr>
                              <tr>
                                <td>王李四</td>
                                <td>46**4213</td>
                                <td>科宝外语学校</td>
                                <td>100</td>
                                <td>10</td>
                                <td>语文</td>
                              </tr>
                              <tr>
                                <td>王李四</td>
                                <td>46**4213</td>
                                <td>科宝外语学校</td>
                                <td>100</td>
                                <td>10</td>
                                <td>语文</td>
                              </tr>
                              <tr>
                                <td>王李四</td>
                                <td>46**4213</td>
                                <td>科宝外语学校</td>
                                <td>100</td>
                                <td>10</td>
                                <td>语文</td>
                              </tr>
                              <tr>
                                <td>王李四</td>
                                <td>46**4213</td>
                                <td>科宝外语学校</td>
                                <td>100</td>
                                <td>10</td>
                                <td>语文</td>
                              </tr>
                              </tbody>
                            </table>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="card">
                    <div class="card-header">本学期平均分增幅排名</div>
                    <div class="card-body">
                      <div class="row">
                        <div class="col-md-12">
                          <div class="table-responsive" style="overflow: auto">
                            <table class="table table-striped" style="white-space: nowrap">
                              <thead>
                              <tr>
                                <th scope="col">序号</th>
                                <th scope="col">学校名称</th>
                                <th scope="col">语文</th>
                                <th scope="col">排名</th>
                                <th scope="col">数学</th>
                                <th scope="col">排名</th>
                                <th scope="col">英语</th>
                                <th scope="col">排名</th>
                              </tr>
                              </thead>
                              <tbody>
                              <tr>
                                <td>1</td>
                                <td>科宝外语学校</td>
                                <td>66%</td>
                                <td>10</td>
                                <td>18%</td>
                                <td>1</td>
                                <td>1%</td>
                                <td>78</td>
                              </tr>
                              <tr>
                                <td>1</td>
                                <td>科宝外语学校</td>
                                <td>66%</td>
                                <td>10</td>
                                <td>18%</td>
                                <td>1</td>
                                <td>1%</td>
                                <td>78</td>
                              </tr>
                              <tr>
                                <td>1</td>
                                <td>科宝外语学校</td>
                                <td>66%</td>
                                <td>10</td>
                                <td>18%</td>
                                <td>1</td>
                                <td>1%</td>
                                <td>78</td>
                              </tr>
                              <tr>
                                <td>1</td>
                                <td>科宝外语学校</td>
                                <td>66%</td>
                                <td>10</td>
                                <td>18%</td>
                                <td>1</td>
                                <td>1%</td>
                                <td>78</td>
                              </tr>
                              <tr>
                                <td>1</td>
                                <td>科宝外语学校</td>
                                <td>66%</td>
                                <td>10</td>
                                <td>18%</td>
                                <td>1</td>
                                <td>1%</td>
                                <td>78</td>
                              </tr>
                              <tr>
                                <td>1</td>
                                <td>科宝外语学校</td>
                                <td>66%</td>
                                <td>10</td>
                                <td>18%</td>
                                <td>1</td>
                                <td>1%</td>
                                <td>78</td>
                              </tr>
                              <tr>
                                <td>1</td>
                                <td>科宝外语学校</td>
                                <td>66%</td>
                                <td>10</td>
                                <td>18%</td>
                                <td>1</td>
                                <td>1%</td>
                                <td>78</td>
                              </tr>
                              <tr>
                                <td>1</td>
                                <td>科宝外语学校</td>
                                <td>66%</td>
                                <td>10</td>
                                <td>18%</td>
                                <td>1</td>
                                <td>1%</td>
                                <td>78</td>
                              </tr>
                              <tr>
                                <td>1</td>
                                <td>科宝外语学校</td>
                                <td>66%</td>
                                <td>10</td>
                                <td>18%</td>
                                <td>1</td>
                                <td>1%</td>
                                <td>78</td>
                              </tr>
                              </tbody>
                            </table>
                            <nav aria-label="Page navigation example">
                              <ul class="pagination justify-content-end">
                                <li class="page-item disabled">
                                  <a class="page-link" href="#" tabindex="-1" aria-disabled="true">上一页</a>
                                </li>
                                <li class="page-item">
                                  <a class="page-link" href="#">下一页</a>
                                </li>
                              </ul>
                            </nav>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- end::chat list -->
      </div>
    </div>
    <!-- begin::footer -->
    <footer>
      <div class="container-fluid">
        <div>© 2021 xxxxxxxxx - xxxxxx</div>
      </div>
    </footer>
    <!-- end::footer -->

  </div>
</template>

<script>
export default {
  name: "Index",
  data() {
    return {
      // 版本号
      version: "3.7.0",
    };
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    },
  },
};
</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
}
</style>

