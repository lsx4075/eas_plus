<%--
  Created by IntelliJ IDEA.
  User: 喜洋洋酱
  Date: 2026/8/27
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    /* 全局 */
    body {
        background-color: #F8F8F8;
        font-family: "Helvetica Neue", Helvetica, Arial, "Microsoft YaHei", sans-serif;
        color: #333;
        padding: 20px;
    }
    h3 {
        color: #333;
        border-bottom: 1px solid #e0e0e0;
        padding-bottom: 10px;
        margin-top: 0;
    }
    /* 表格 */
    .table {
        width: 100%;
        background-color: #fff;
        border-collapse: collapse;
        border: 1px solid #ddd;
        font-size: 14px;
    }
    .table th, .table td {
        padding: 8px 12px;
        border: 1px solid #ddd;
        text-align: left;
        vertical-align: middle;
    }
    .table th {
        background-color: #f5f5f5;
        color: #333;
        font-weight: bold;
    }
    .table tbody tr:hover {
        background-color: #f9f9f9;
    }
    /* 按钮 */
    .btn {
        display: inline-block;
        padding: 6px 16px;
        font-size: 14px;
        font-weight: normal;
        line-height: 1.42857143;
        text-align: center;
        white-space: nowrap;
        vertical-align: middle;
        cursor: pointer;
        background-image: none;
        border: 1px solid transparent;
        border-radius: 4px;
        color: #fff;
        text-decoration: none;
        margin: 2px;
    }
    .btn-primary {
        background-color: #3070B0;
        border-color: #3070B0;
    }
    .btn-primary:hover {
        background-color: #286090;
        border-color: #286090;
    }
    .btn-danger {
        background-color: #D05050;
        border-color: #D05050;
    }
    .btn-danger:hover {
        background-color: #c9302c;
        border-color: #c9302c;
    }
    .btn-default {
        background-color: #e6e6e6;
        border-color: #ccc;
        color: #333;
    }
    .btn-default:hover {
        background-color: #d4d4d4;
    }
    .btn-sm {
        padding: 3px 10px;
        font-size: 12px;
    }
    /* 输入框 */
    .form-control {
        display: inline-block;
        padding: 6px 12px;
        font-size: 14px;
        line-height: 1.42857143;
        color: #555;
        background-color: #fff;
        background-image: none;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
        transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
        width: auto;
    }
    .form-control:focus {
        border-color: #3070B0;
        outline: 0;
        box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(48,112,176,.6);
    }
    /* 搜索组合 */
    .search-group {
        margin-bottom: 15px;
    }
    .search-group .form-control {
        width: 200px;
        margin-right: 5px;
    }
    /* 分页 */
    .pagination {
        display: inline-block;
        padding-left: 0;
        margin: 20px 0;
        border-radius: 4px;
    }
    .pagination a, .pagination span {
        display: inline-block;
        padding: 6px 12px;
        margin-left: -1px;
        line-height: 1.42857143;
        color: #3070B0;
        text-decoration: none;
        background-color: #fff;
        border: 1px solid #ddd;
    }
    .pagination a:hover {
        background-color: #eee;
    }
    .pagination .active span {
        background-color: #3070B0;
        color: #fff;
        border-color: #3070B0;
        cursor: default;
    }
    .pagination .disabled span {
        color: #999;
        cursor: not-allowed;
    }
    /* 表单 */
    .form-group {
        margin-bottom: 15px;
    }
    .form-group label {
        display: inline-block;
        font-weight: bold;
        margin-right: 10px;
        min-width: 80px;
        text-align: right;
    }
    .form-group .form-control {
        width: 250px;
    }
    /* 表单表格辅助 */
    .form-table {
        border: none;
        width: auto;
    }
    .form-table td {
        padding: 6px 10px;
        border: none;
        vertical-align: middle;
    }
    .form-table td:first-child {
        text-align: right;
        font-weight: bold;
        width: 120px;
    }
    .form-table .form-control {
        width: 250px;
    }
    .form-table .btn {
        margin: 0 5px;
    }
    /* 其他 */
    .text-danger {
        color: #D05050;
    }
    .text-muted {
        color: #999;
    }
    /* 表格内按钮间隔 */
    .table .btn {
        margin: 0 2px;
    }
    /* 错误信息 */
    .error-msg {
        color: red;
        font-size: 12px;
    }
</style>
