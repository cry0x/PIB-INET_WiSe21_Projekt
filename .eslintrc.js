module.exports = {
    env: {
        browser: true,
        es2021: true,
    },
    extends: ['airbnb-base'],
    parserOptions: {
        ecmaVersion: 13,
        sourceType: 'module',
    },
    plugins: ['html'],
    // Sets indentation rue to 4 spaces instead of 2
    rules: {
        indent: ['error', 4],
    },
};
