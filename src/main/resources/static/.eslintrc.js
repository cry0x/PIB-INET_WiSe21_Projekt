module.exports = {
    env: {
        browser: true,
        es2021: true,
        jquery: true,
    },
    extends: ['airbnb-base', 'prettier'],
    parserOptions: {
        ecmaVersion: 13,
        sourceType: 'module',
    },
    plugins: ['html'],
    // Sets indentation rue to 4 spaces instead of 2
    rules: {
        indent: ['error', 4],
        allowForLoopAfterthoughts: 0,
    },
}
