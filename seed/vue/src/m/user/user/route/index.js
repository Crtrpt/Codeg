var route=[
    {
        name: "UserList",
        path: "/user/list",
        component: () => import("../page/UserList.vue"),
    },
    {
        name: "UserForm",
        path: "/user/new",
        component: () => import("../page/UserForm.vue"),
    },
    {
        name: "UserDetail",
        path: "/user/:id",
        component: () => import("../page/UserDetail.vue"),
    },
]

export default route;