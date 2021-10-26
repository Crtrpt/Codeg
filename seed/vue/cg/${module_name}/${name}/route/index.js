var route=[
    {
        name: "${filename}List",
        path: "/${name}/list",
        component: () => import("../page/${filename}List.vue"),
    },
    {
        name: "${filename}Form",
        path: "/${name}/new",
        component: () => import("../page/${filename}Form.vue"),
    },
    {
        name: "${filename}Detail",
        path: "/${name}/:id",
        component: () => import("../page/${filename}Detail.vue"),
    },
]

export default route;